package com.sacavix.ca.moneytransfers.application.port.in;

public interface SendMoneyPort {
    boolean send(SendMoneyCommand command);
}
