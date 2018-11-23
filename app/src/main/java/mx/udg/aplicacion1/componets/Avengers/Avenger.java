package mx.udg.aplicacion1.componets.Avengers;

public class Avenger {
    private String nombre;
    private String imagen;
    private String frase;
    private boolean dead;
    private boolean gema;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean isGema() {
        return gema;
    }

    public void setGema(boolean gema) {
        this.gema = gema;
    }
}
