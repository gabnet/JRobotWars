package utils;

public class FaceManager {

	public static Face GetZeroFace(){
		return Face.N;
	}
	
	public static Face Right(Face currentFace){
		switch (currentFace){
		case N:
			return Face.E;
		case E:
			return Face.S;
		case S:
			return Face.W;
		default:
			return Face.N;
		}
	}
	
	public static Face Left(Face currentFace){
		switch (currentFace){
		case N:
			return Face.W;
		case W:
			return Face.S;
		case S:
			return Face.E;
		default:
			return Face.N;
		}
	}
}
