package aula5;

public class ContaBanco {
    //Atributos
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;
    //Metodos
    public void estadoAtual(){
        System.out.println("-----------------------------");
        System.out.println("Conta: " + this.getNumConta());
        System.out.println("Tipo: " + getTipo());
        System.out.println("Dono: " + getDono());
        System.out.println("Saldo: " + getSaldo());
        
    }
    
    public void abrirConta(String t){
        this.setTipo(t);
        this.setStatus(true);
        if (t == "CC") {
            this.setSaldo(50);;
        } else if(t == "CP") {
            this.setSaldo(150);;
        }

    }

    public void fecharConta(){
        if (this.getSaldo() > 0){
            System.out.println("Não se pode fechar a conta pois saldo maior que 0.");
        } else if (this.getSaldo() < 0){
            System.out.println("Não se pode fechar a conta pois saldo menor que 0.");
        } else {
            this.setStatus(false);
            System.out.println("Conta fechada!");
        }

    }

    public void depositar(float v){
        if (this.getStatus()){
            this.setSaldo(getSaldo() + v);
            System.out.println("Deposito feito na conta de " + this.getDono());
        } else {
            System.out.println("Não é possivel depositar numa conta fechada!");
        }

    }

    public void sacar(float v){
        if (this.getStatus()) {
            if (this.getSaldo() >= v){
                this.setSaldo(getSaldo() - v);
                System.out.println("Saque realizado na conta de " + this.getDono());
            } else {
                System.out.println("Saldo insuficiente para saque.");
            }
        } else {
            System.out.println("Impossivel sacar com conta fechada.");
        }


    }

    public void pagarMensal(){
        int v = 0;
        if(this.getTipo() == "CC") {
            v = 12;
        } else if (this.getTipo() == "CP"){
            v = 20;
        }
        if (this.getStatus()){
            this.setSaldo(getSaldo() - v);
            System.out.println("Mensalidade de " + this.getDono() + " paga com sucesso!");
        } else {
            System.out.println("Impossivel pagar mensalidade com a conta fechada.");
        }

    }
    //Metodos especiais
    public ContaBanco(){

        this.setSaldo(0);
        this.setStatus(false);

    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
