interface Image{
    void display();
}
class RealImage implements Image{
    String imageName;
    RealImage(String imageName){
        this.imageName=imageName;
        loadImage();
    }
    public void loadImage(){
        System.out.println("Loading Image: "+imageName);
    }
    public void display(){
        System.out.println("Displaying Name: "+imageName);
    }
}
class ProxyImage implements Image{
    RealImage r;
    String imageName;
    
    ProxyImage(String imageName){
        this.imageName=imageName;
    }
    
    public void display(){
        if(r==null){
            r=new RealImage(imageName);
        }
        r.display();
    }
}
public class ProxyPatternExample
{
	public static void main(String[] args) {
		Image image1=new ProxyImage("Image-1.jpg");
		image1.display();

	}
}