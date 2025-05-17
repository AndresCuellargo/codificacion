abstract class LeyNewton {
    public abstract String explicar();

    public abstract double calcular(double... valores);
}

class PrimeraLey extends LeyNewton {
    public String explicar() {
        return "Si la fuerza neta es cero, el objeto mantiene su estado de movimiento o reposo.";
    }

    public double calcular(double... valores) {
        return 0;
    }
}

class SegundaLey extends LeyNewton {
    public String explicar() {
        return "La fuerza es igual a la masa por la aceleración: F = m * a";
    }

    public double calcular(double... valores) {
        return valores[0] * valores[1];
    }
}

class TerceraLey extends LeyNewton {
    public String explicar() {
        return "A toda acción hay una reacción igual y contraria.";
    }

    public double calcular(double... valores) {
        return -valores[0];
    }
}
