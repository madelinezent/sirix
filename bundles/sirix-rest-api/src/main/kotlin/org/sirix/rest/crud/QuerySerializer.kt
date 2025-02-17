package org.sirix.rest.crud

import io.vertx.ext.auth.User
import io.vertx.ext.auth.authorization.AuthorizationProvider
import io.vertx.ext.auth.oauth2.OAuth2Auth
import org.brackit.xquery.jdm.Item
import org.brackit.xquery.util.serialize.Serializer
import org.sirix.xquery.SirixCompileChain
import org.sirix.xquery.SirixQueryContext

class QuerySerializer {
    companion object {
        fun serializePaginated(
            sirixCompileChain: SirixCompileChain,
            query: String,
            queryCtx: SirixQueryContext,
            startResultSeqIndex: Long,
            endResultSeqIndex: Long?,
            keycloak: OAuth2Auth,
            authz: AuthorizationProvider,
            user: User,
            serializer: Serializer,
            serialize: (Serializer, Item?) -> Unit
        ) {
            serializer.use {
                val sequence =
                    PermissionCheckingXQuery(sirixCompileChain, query, keycloak, user, authz).execute(queryCtx)

                if (sequence != null) {
                    val itemIterator = sequence.iterate()

                    for (i in 0 until startResultSeqIndex) {
                        itemIterator.next()
                    }

                    if (endResultSeqIndex == null) {
                        while (true) {
                            val item = itemIterator.next()

                            if (item == null)
                                break
                            else
                                serialize(serializer, item)
                        }
                    } else {
                        for (i in startResultSeqIndex..endResultSeqIndex) {
                            val item = itemIterator.next()

                            if (item == null)
                                break
                            else
                                serialize(serializer, item)
                        }
                    }
                }
            }
        }
    }
}