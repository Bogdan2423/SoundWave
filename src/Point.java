import static java.lang.System.out;

public class Point {

	public Point nNeighbor;
	public Point wNeighbor;
	public Point eNeighbor;
	public Point sNeighbor;
	public float nVel;
	public float eVel;
	public float wVel;
	public float sVel;
	public float pressure;
	public static Integer[] types ={0,1,2};
	public int type;
	public int sinInput=10;

	public Point() {
		type=0;
		clear();
	}

	public void clicked() {
		pressure = 1;
	}
	
	public void clear() {
		// TODO: clear velocity and pressure
		nVel=0;
		eVel=0;
		wVel=0;
		sVel=0;
		pressure=0;
	}

	public void updateVelocity() {
		// TODO: velocity update
		if (type==0) {
			nVel = nVel - (nNeighbor.pressure - pressure);
			eVel = eVel - (eNeighbor.pressure - pressure);
			wVel = wVel - (wNeighbor.pressure - pressure);
			sVel = sVel - (sNeighbor.pressure - pressure);
		}
	}

	public void updatePresure() {
		// TODO: pressure update
		if (type==0)
			pressure= (float) (pressure-(0.5)*(nVel+eVel+wVel+sVel));
		if (type==2)
		{
			sinInput+=10;
			if(sinInput==360)
				sinInput=0;
			double radians = Math.toRadians(sinInput);
			pressure = (float) (Math.sin(radians));
		}
	}

	public float getPressure() {
		return pressure;
	}
}