package parcelas.services;

import parcelas.entities.Contract;
import parcelas.entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months){
        double basicPay = contract.getTotalValue() / months;

        for (int i= 1; i <= months; i++){
            // data de vencimento
            LocalDate dueDate = contract.getDate().plusMonths(i);
            // juro por mes
            double interest = onlinePaymentService.interest(basicPay, i);

            double fee = onlinePaymentService.paymentFee(basicPay + interest);

            double totalPay = basicPay + interest + fee;

            contract.getInstallments().add(new Installment(dueDate, totalPay));
        }
    }
}
