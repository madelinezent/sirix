/**
 * Copyright (c) 2011, University of Konstanz, Distributed Systems Group
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * * Neither the name of the University of Konstanz nor the
 * names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.sirix.api.visitor;

import javax.annotation.Nonnull;

import org.sirix.node.immutable.ImmutableAttribute;
import org.sirix.node.immutable.ImmutableComment;
import org.sirix.node.immutable.ImmutableDocument;
import org.sirix.node.immutable.ImmutableElement;
import org.sirix.node.immutable.ImmutableNamespace;
import org.sirix.node.immutable.ImmutablePI;
import org.sirix.node.immutable.ImmutableText;

/**
 * Interface which must be implemented from visitors to implement functionality
 * based on the visitor pattern.
 * 
 * @author Johannes Lichtenberger, University of Konstanz
 * 
 */
public interface IVisitor {
  /**
   * Do something when visiting a {@link ImmutablePI}.
   * 
   * @param pNode
   *          the {@link ImmutablePI}
   */
  EVisitResult visit(@Nonnull final ImmutablePI pNode);
  
  /**
   * Do something when visiting a {@link ImmutableComment}.
   * 
   * @param pNode
   *          the {@link ImmutableComment}
   */
  EVisitResult visit(@Nonnull final ImmutableComment pNode);
	
  /**
   * Do something when visiting an {@link ImmutableElement}.
   * 
   * @param pNode
   *          the {@link ImmutableElement}
   */
  EVisitResult visit(@Nonnull final ImmutableElement pNode);

  /**
   * Do something when visiting a {@link ImmutableAttribute}.
   * 
   * @param pNode
   *          the {@link ImmutableAttribute}
   */
  EVisitResult visit(@Nonnull final ImmutableAttribute pNode);

  /**ImmutableDocumentRoot
   * Do something when visiting a {@link ImmutableNamespace}.
   * 
   * @param pNode
   *          the {@link ImmutableNamespace}
   */
  EVisitResult visit(@Nonnull final ImmutableNamespace pNode);

  /**
   * Do something when visiting a {@link ImmutableText}.
   * 
   * @param pNode
   *          the {@link ImmutableText}
   */
  EVisitResult visit(@Nonnull final ImmutableText pNode);

  /**
   * Do something when visiting the {@link ImmutableDocument}.
   * 
   * @param pNode
   *          the {@link ImmutableDocument}
   */
  EVisitResult visit(@Nonnull final ImmutableDocument pNode);
}
