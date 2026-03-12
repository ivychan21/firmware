CascadeClassifier faceDetector =
        new CascadeClassifier("haarcascade_frontalface.xml");

Mat image = Imgcodecs.imread("camera.jpg");

MatOfRect faceDetections = new MatOfRect();

faceDetector.detectMultiScale(image, faceDetections);

if(faceDetections.toArray().length > 0){
        System.out.println("Face detected");
}