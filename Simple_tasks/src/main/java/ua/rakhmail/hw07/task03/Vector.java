package ua.rakhmail.hw07.task03;

import java.util.Random;

public class Vector {

    // координаты.
    double x;
    double y;
    double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double vectorLength() {
        double x = 0;
        x = Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
        return Math.abs(x);
    }

    public Vector vectorVecPro(Vector vector) {
        double a = this.y * vector.z - this.z * vector.y;
        double b = this.z * vector.x - this.x * vector.z;
        double c = this.x * vector.y - this.y * vector.x;
        return new Vector(a, b, c);
    }

    public double vectorScalarPro(Vector vector) {
        double a = 0;
        a = this.x * vector.x + this.y * vector.y + this.z * vector.z;
        return a;
    }

    public double vectorCos(Vector vector) {
        double a = 0;
        a = this.vectorScalarPro(vector) / (this.vectorLength() * vector.vectorLength());
        return a;
    }


    public Vector vectorSum(Vector vector) {
        double a = this.x + vector.x;
        double b = this.y + vector.y;
        double c = this.z + vector.z;
        return new Vector(a, b, c);
    }

    public Vector vectorSubtraction(Vector vector) {
        double a = this.x - vector.x;
        double b = this.y - vector.y;
        double c = this.z - vector.z;
        return new Vector(a, b, c);
    }

    public static Vector[] vectorRandomArray(int n) {
        Vector[] vectors = new Vector[n];
        Random random = new Random();
        for (int i = 0; i < vectors.length; i++) {
            vectors[i] = new Vector(random.nextInt(25), random.nextInt(25), random.nextInt(25));
        }
        return vectors;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
