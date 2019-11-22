package cn.his.entity;

/**
 * 发票和挂号单合并第一个实体类，用于接收数据时用作对象
 */
public class RegAndInv {
    //挂号对象
    private Register register;
    //发票对象
    private Invoice invoice;

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;

    }
    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
