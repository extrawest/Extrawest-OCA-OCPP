package com.extrawest.ocppJ;
/*
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

import com.extrawest.common.RadioEvents;
import com.extrawest.common.Receiver;

public class WebSocketReceiver implements Receiver {

  private RadioEvents handler;
  private WebSocketReceiverEvents receiverEvents;

  public WebSocketReceiver(WebSocketReceiverEvents handler) {
    receiverEvents = handler;
  }

  @Override
  public void disconnect() {
    receiverEvents.close();
    handler.disconnected();
  }

  void relay(String message) {
    handler.receivedMessage(message);
  }

  @Override
  public void send(Object message) {
    receiverEvents.relay(message.toString());
  }

  @Override
  public boolean isClosed() {
    return receiverEvents.isClosed();
  }

  @Override
  public void accept(RadioEvents events) {
    handler = events;
  }
}
