package com.small.api.bank.architecture.port;

import com.small.api.bank.architecture.domain.dto.DepositDto;

/**
 * Port provides application functionality to the outside
 */
public interface DepositService {


    DepositDto addDeposit(DepositDto deposit);
    

}