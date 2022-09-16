package cadastro_de_filmes.objects;

public class Filme {
    public String Titulo;
    public int Ano;
    public String Diretor;
    public String[] Generos = new String[10];
    public int Minutos;

    public Filme(String Titulo, int Ano, String Diretor, int Minutos, String[] Generos) {
        this.Titulo = Titulo;
        this.Ano = Ano;
        this.Diretor = Diretor;
        this.Minutos = Minutos;
        this.Generos = Generos;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public void setAno(int Ano) {
        this.Ano = Ano;
    }

    public void setDiretor(String Diretor) {
        this.Diretor = Diretor;
    }

    public void setGeneros(String[] Generos) {
        this.Generos = Generos;
    }

    public void setMinutos(int Minutos) {
        this.Minutos = Minutos;
    }

    public String getTitulo() {
        return Titulo;
    }

    public int getAno() {
        return Ano;
    }

    public String getDiretor() {
        return Diretor;
    }

    public String[] getGeneros() {
        return Generos;
    }

    public int getMinutos() {
        return Minutos;
    }

    public String ToString() {
        String generos = Generos[0];
        for (int i = 1; i < Generos.length; i++) {
            if (Generos[i] != null) {
                generos += " | " + Generos[i];
            }
        }
        return Titulo + "/" + Ano + "/" + Diretor + "/" + generos + "/" + Minutos;
    }
}
