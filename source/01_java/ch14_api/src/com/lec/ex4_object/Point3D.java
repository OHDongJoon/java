package com.lec.ex4_object;

public class Point3D implements Cloneable {
	private double x;
	private double y;
	private double z;

	public Point3D() {}

	public Point3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Point3D) {
			boolean xChk = (x == ((Point3D) obj).x);
			boolean yChk = (y == ((Point3D) obj).y);
			boolean zChk = (z == ((Point3D) obj).z);
			return xChk && yChk && zChk;
		}
		return false;

	}

	@Override
	public String toString() {
		return "Point3D [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
