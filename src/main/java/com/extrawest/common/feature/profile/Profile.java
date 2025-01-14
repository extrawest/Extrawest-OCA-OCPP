package com.extrawest.common.feature.profile;
/*
ChargeTime.eu - Java-OCA-OCPP
Copyright (C) 2015-2016 Thomas Volden <tv@chargetime.eu>

MIT License

Copyright (C) 2016-2018 Thomas Volden

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



import com.extrawest.common.feature.Feature;
import com.extrawest.common.feature.ProfileFeature;
import com.extrawest.common.model.Confirmation;
import com.extrawest.common.model.Request;

import java.util.UUID;

/** Interface used for Feature Profiles. */
public interface Profile {

  /**
   * Get a list of supported Feature for this Feature Profile.
   *
   * @return supported {@link Feature}s
   */
  ProfileFeature[] getFeatureList();

  /**
   * Handle {@link Request}
   *
   * @param sessionIndex source of the request.
   * @param request the {@link Request} to be handled.
   * @return the {@link Confirmation} to be send.
   */
  Confirmation handleRequest(UUID sessionIndex, Request request);
}
