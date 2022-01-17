package com.small.api.bank.architecture.port;

import com.small.api.bank.architecture.domain.dto.TransferDto;

/**
 * Port provides application functionality to the outside
 */
public interface TransferService {

    TransferDto doTransfer(TransferDto transfer) throws Exception;
    
}