/*
 * Copyright 2011-2016 Gregory Shrago
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.intellij.grammar.refactor;

import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.refactoring.RefactoringActionHandler;
import com.intellij.refactoring.actions.BasePlatformRefactoringAction;
import org.intellij.grammar.psi.BnfFile;
import org.jetbrains.annotations.NotNull;

/**
 * @author greg
 */
public class BnfIntroduceTokenAction extends BasePlatformRefactoringAction {
  public BnfIntroduceTokenAction() {
  }

  protected boolean isAvailableInEditorOnly() {
    return true;
  }

  @Override
  protected boolean isAvailableForFile(PsiFile file) {
    return file instanceof BnfFile;
  }

  protected boolean isEnabledOnElements(@NotNull PsiElement[] elements) {
    return false;
  }

  @Override
  protected RefactoringActionHandler getRefactoringHandler(@NotNull RefactoringSupportProvider provider) {
    return new BnfIntroduceTokenHandler();
  }
}

