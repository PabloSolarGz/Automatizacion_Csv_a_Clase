package utils;

public class Credencial {
    private String usuario;
    private String navegador;
    private String ambiente;
    private String url;
    private String password;
    private String perfilUsuario;
    private String comision;

    private Credencial(Builder builder) {
        this.usuario = builder.usuario;
        this.navegador = builder.navegador;
        this.ambiente = builder.ambiente;
        this.url = builder.url;
        this.password = builder.password;
        this.perfilUsuario = builder.perfilUsuario;
        this.comision = builder.comision;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getNavegador() {
        return navegador;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public String getUrl() {
        return url;
    }

    public String getPassword() {
        return password;
    }

    public String getPerfilUsuario() {
        return perfilUsuario;
    }

    public String getComision() {
        return comision;
    }

    public static class Builder {
        private String usuario;
        private String navegador;
        private String ambiente;
        private String url;
        private String password;
        private String perfilUsuario;
        private String comision;

        public Builder usuario(String usuario) {
            this.usuario = usuario;
            return this;
        }

        public Builder navegador(String navegador) {
            this.navegador = navegador;
            return this;
        }

        public Builder ambiente(String ambiente) {
            this.ambiente = ambiente;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder perfilUsuario(String perfilUsuario) {
            this.perfilUsuario = perfilUsuario;
            return this;
        }

        public Builder comision(String comision) {
            this.comision = comision;
            return this;
        }

        public Credencial build() {
            return new Credencial(this);
        }
    }
}
