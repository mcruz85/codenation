package br.com.codenation;

import java.util.Objects;

public class IdentificarJogador {

    private final long id;
    private final long idTime;

    public IdentificarJogador(long id, long idTime) {
        this.id = id;
        this.idTime = idTime;
    }

    public long getId() {
        return id;
    }

    public long getIdTime() {
        return idTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentificarJogador that = (IdentificarJogador) o;
        return id == that.id &&
                idTime == that.idTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idTime);
    }
}
