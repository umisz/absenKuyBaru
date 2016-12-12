package com.example.imul.absenkuybaru;


/**
 * Created by Imul on 03-Dec-16.
 */


public class Absen {
    int _id;
    String _namaAng;
    String _kyu;
    String _nrp;
    String _telat;
    String _created_at;

    public Absen() {

    }

    public Absen(String namaAng, String nrp, String kyu, String telat) {
        this._namaAng = namaAng;
        this._nrp = nrp;
        this._kyu = kyu;
        this._telat = telat;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_namaAng() {
        return _namaAng;
    }

    public void setCreatedAt(String created_at){
        this._created_at = created_at;
    }

    public void set_namaAng(String _namaAng) {
        this._namaAng = _namaAng;
    }

    public String get_kyu() {
        return _kyu;
    }

    public void set_kyu(String _kyu) {
        this._kyu = _kyu;
    }

    public String get_nrp() {
        return _nrp;
    }

    public void set_nrp(String _nrp) {
        this._nrp = _nrp;
    }

    public String get_telat() {
        return _telat;
    }

    public void set_telat(String _telat) {
        this._telat = _telat;
    }
}
