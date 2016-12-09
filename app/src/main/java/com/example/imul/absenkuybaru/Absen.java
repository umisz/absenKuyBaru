package com.example.imul.absenkuybaru;


/**
 * Created by Imul on 03-Dec-16.
 */


public class Absen {
    private int _id;
    private String _namaAng;
    private String _kyu;
    private String _tglAbsen;

    public Absen() {

    }

    public Absen(String namaAng, String kyu, String tglAbsen) {
        this._namaAng = namaAng;
        this._kyu = kyu;
        this._tglAbsen = tglAbsen;
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

    public void set_namaAng(String _namaAng) {
        this._namaAng = _namaAng;
    }

    public String get_kyu() {
        return _kyu;
    }

    public void set_kyu(String _kyu) {
        this._kyu = _kyu;
    }

    public String get_tglAbsen() {
        return _tglAbsen;
    }

    public void set_tglAbsen(String _tglAbsen) {
        this._tglAbsen = _tglAbsen;
    }
}
