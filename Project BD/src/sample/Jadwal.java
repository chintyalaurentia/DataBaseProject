package sample;

public class Jadwal {
    String namaDokter;
    String tanggal;
    String jam;

    public Jadwal(String namaDokter, String tanggal, String jam) {
        this.namaDokter = namaDokter;
        this.tanggal = tanggal;
        this.jam = jam;
    }

    public Jadwal(String namaDokter) {
        this.namaDokter = namaDokter;
    }

    public String getNamaDokter() {
        return namaDokter;
    }

    public void setNamaDokter(String namaDokter) {
        this.namaDokter = namaDokter;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }
}
