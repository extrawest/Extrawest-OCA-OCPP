package com.extrawest.ocpp_2_0_1.model.validation;
/*
   ChargeTime.eu - Java-OCA-OCPP

   MIT License

   Copyright (C) 2018 Thomas Volden <tv@chargetime.eu>

   Permission is hereby granted, free of charge, to any person obtaining a copy
   of this software and associated documentation files (the "Software"), to deal
   in the Software without restriction, including without limitation the rights
   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
   copies of the Software, and to permit persons to whom the Software is
   furnished to do so, subject to the following conditions:

   The above copyright notice and this permission notice shall be included in all
   copies or substantial portions of the Software.

   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
   SOFTWARE.
*/

import com.extrawest.common.PropertyConstraintException;
import com.extrawest.common.model.validation.IValidationRule;

import java.util.regex.Pattern;

public class IdentifierStringValidationRule implements IValidationRule {
  private final String ERROR_MESSAGE = "Illegal character(s) in IdentifierString.";
  private final String PATTERN = "([a-zA-Z0-9]|\\*|\\-|\\_|\\=|\\:|\\+|\\||\\@|\\.)+";

  @Override
  public void validate(String value) throws PropertyConstraintException {
    if (!match(value)) {
      throw new PropertyConstraintException(value, ERROR_MESSAGE);
    }
  }

  private boolean match(String value) {
    Pattern pattern = Pattern.compile(PATTERN);
    return pattern.matcher(value).matches();
  }
}
