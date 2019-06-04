package model;

public class FolhaDePagamento {

    private double salariobruto;
    private double inss;
    private double irrf;
    private double salarioliquido;
    private double plussalario;

    public double getInss() {
        return inss;
    }

    public void setInss(double inss) {
        this.inss = inss;
    }

    public double getIrrf() {
        return irrf;
    }

    public double getPlussalario() {
        return plussalario;
    }

    public double getSalarioliquido() {
        return salarioliquido;
    }

    public void setIrrf(double irrf) {
        this.irrf = irrf;
    }

    public double getSalariobruto() {
        return salariobruto;
    }

    public void setSalariobruto(double salariobruto) {
        this.salariobruto = salariobruto;
    }

    public void setPlussalario(double plussalario) {
        this.plussalario = plussalario;
    }

    public void setSalarioliquido(double salarioliquido) {
        this.salarioliquido = salarioliquido;
    }

    private double calcularInss() {

        double salariobrutoauxiliar = salariobruto;

        // Por conta do Teto
        if (salariobruto > 5645.80) {
            salariobrutoauxiliar = 5645.80;
        }

        if (salariobruto <= 1693.72) {
            inss = 0.08;

        } else if (salariobruto >= 1693.73 && salariobruto <= 2822.90) {
            inss = 0.09;
        } else if (salariobruto >= 2822.91 && salariobruto <= 5645.80) {
            inss = 0.11;
        }
        return salariobrutoauxiliar * inss;
    }

    private double calcularIrrf() {
        double parcela = 0;

        if (salariobruto >= 1903.99 && salariobruto <= 2826.65) {
            parcela = 142.80;
            irrf = 0.075;
        } else if (salariobruto >= 2826.66 && salariobruto <= 3751.05) {
            parcela = 354.80;
            irrf = 0.15;
        } else if (salariobruto >= 3751.06 && salariobruto <= 4664.68) {
            parcela = 363.13;
            irrf = 0.225;
        } else if (salariobruto >= 4664.69) {
            parcela = 869.36;
            irrf = 0.275;
        }

        return ((salariobruto * irrf) - parcela);
    }

    public double calcularSalarioLiquido() {
        salarioliquido = salariobruto - calcularInss() - calcularIrrf();
        return salarioliquido ;
    }

}
