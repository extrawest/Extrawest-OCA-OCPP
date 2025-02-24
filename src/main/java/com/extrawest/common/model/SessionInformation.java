package com.extrawest.common.model; /*
                                     ChargeTime.eu - Java-OCA-OCPP

                                     MIT License

                                     Copyright (C) 2016-2018 Thomas Volden <tv@chargetime.eu>

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

import java.net.InetSocketAddress;

public class SessionInformation {

  private String identifier;
  private InetSocketAddress address;
  private String SOAPtoURL;
  private String proxiedAddress;

  public String getIdentifier() {
    return identifier;
  }

  public InetSocketAddress getAddress() {
    return address;
  }

  public String getSOAPtoURL() {
    return SOAPtoURL;
  }

  public String getProxiedAddress() {
    return proxiedAddress;
  }

  public static class Builder {

    private String identifier;
    private InetSocketAddress address;
    private String SOAPtoURL;
    private String proxiedAddress;

    public Builder Identifier(String identifier) {
      this.identifier = identifier;
      return this;
    }

    public Builder InternetAddress(InetSocketAddress address) {
      this.address = address;
      return this;
    }

    public Builder ProxiedAddress(String proxiedAddress) {
      this.proxiedAddress = proxiedAddress;
      return this;
    }

    public SessionInformation build() {
      SessionInformation sessionInformation = new SessionInformation();
      sessionInformation.identifier = this.identifier;
      sessionInformation.address = this.address;
      sessionInformation.SOAPtoURL = this.SOAPtoURL;
      sessionInformation.proxiedAddress = this.proxiedAddress;
      return sessionInformation;
    }

    public Builder SOAPtoURL(String toUrl) {
      this.SOAPtoURL = toUrl;
      return this;
    }
  }
}
