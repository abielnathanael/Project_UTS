package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

public class Sphere extends Circle{
    float radiusZ;
    int stackCount;
    int sectorCount;
    public Sphere(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ,
                  int sectorCount,int stackCount) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.radiusZ = radiusZ;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;
//        createBox();
//        createSphere();
//        createCylindric();
        createKepala();

        setupVAOVBO();
    }


    public void createBox(){
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
        //TITIK 1
        temp.x = centerPoint.get(0) - radiusX / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 2
        temp.x = centerPoint.get(0) + radiusX / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 3
        temp.x = centerPoint.get(0) + radiusX / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 4
        temp.x = centerPoint.get(0) - radiusX / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 5
        temp.x = centerPoint.get(0) - radiusX / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 6
        temp.x = centerPoint.get(0) + radiusX / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 7
        temp.x = centerPoint.get(0) + radiusX / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 8
        temp.x = centerPoint.get(0) - radiusX / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();

        vertices.clear();
        //kotak yg sisi belakang
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        //kotak yg sisi depan
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        //kotak yg sisi kiri
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));
        //kotak yg sisi kanan
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));
        //kotak yg sisi atas
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(4));
        //kotak yg sisi bawah
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));
    }
    //    public void draw(){
//        drawSetup();
//        glLineWidth(2); //ketebalan garis
//        glPointSize(2); //besar kecil vertex
//        glDrawArrays(GL_LINE_STRIP,
//                0,
//                vertices.size());
//    }
//    public void createSphere(){
//        float pi = (float)Math.PI;
//
//        float sectorStep = 2 * (float)Math.PI / sectorCount;
//        float stackStep = (float)Math.PI / stackCount;
//        float sectorAngle, StackAngle, x, y, z;
//        ArrayList<Vector3f> temp = new ArrayList<>();

//        for (int i = 0; i <= stackCount; ++i)
//        {
//            StackAngle = pi / 2 - i * stackStep;
//            x = radiusX * (float)Math.cos(StackAngle);
//            y = radiusY * (float)Math.cos(StackAngle);
//            z = radiusZ * (float)Math.sin(StackAngle);
//
//            for (int j = 0; j <= sectorCount; ++j)
//            {
//                sectorAngle = j * sectorStep;
//                Vector3f temp_vector = new Vector3f();
//                temp_vector.x = centerPoint.get(0) + x * (float)Math.cos(sectorAngle);
//                temp_vector.y = centerPoint.get(1) + y * (float)Math.sin(sectorAngle);
//                temp_vector.z = centerPoint.get(2) + z;
//                vertices.add(temp_vector);
//            }
//        }
        //        float pi = (float)Math.PI;
//
//        float sectorStep = 2 * (float)Math.PI / sectorCount;
//        float stackStep = (float)Math.PI / stackCount;
//        float sectorAngle, StackAngle, x, y, z;
//
//        for (int i = 0; i <= stackCount; ++i)
//        {
//            StackAngle = pi / 2 - i * stackStep;
//            x = radiusX * (float)Math.cos(StackAngle);
//            y = radiusY * (float)Math.cos(StackAngle);
//            z = radiusZ * (float)Math.sin(StackAngle);
//
//            for (int j = 0; j <= sectorCount; ++j)
//            {
//                sectorAngle = j * sectorStep;
//                Vector3f temp_vector = new Vector3f();
//                temp_vector.x = centerPoint.get(0) + x * (float)Math.cos(sectorAngle);
//                temp_vector.y = centerPoint.get(1) + y * (float)Math.sin(sectorAngle);
//                temp_vector.z = centerPoint.get(2) + z;
//                vertices.add(temp_vector);
//            }
//        }

//        //Elipsoid
//        ArrayList<Vector3f> temp = new ArrayList<>();
//        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
//            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
//                float x = 0.5f * (float)(Math.cos(v) * Math.cos(u));
//                float y = 0.5f * (float)(Math.cos(v) * Math.sin(u));
//                float z = 0.5f * (float)(Math.sin(v));
//                temp.add(new Vector3f(x,y,z));
//            }
//        }

        //Hyperboloid satu sisi
//        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
//            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
//                float x = 0.5f * (float)((1/Math.cos(v)) * Math.cos(u));
//                float y = 0.5f * (float)((1/Math.cos(v)) * Math.sin(u));
//                float z = 0.5f * (float)(Math.tan(v));
//                temp.add(new Vector3f(x,z,y));
//            }
//        }
        //Hyperboloid dua sisi
//        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
//            for(double u = -Math.PI/2; u<= Math.PI/2; u+=Math.PI/60){
//                float x = 0.5f * (float)(Math.tan(v) * Math.cos(u));
//                float y = 0.5f * (float)(Math.tan(v) * Math.sin(u));
//                float z = 0.5f * (float)(1/Math.cos(v));
//                temp.add(new Vector3f(x,y,z));
//            }
//            for(double u = Math.PI/2; u<= 3*Math.PI/2; u+=Math.PI/60){
//                float x = 0.5f * (float)(Math.tan(v) * Math.cos(u));
//                float y = 0.5f * (float)(Math.tan(v) * Math.sin(u));
//                float z = 0.5f * (float)(1/Math.cos(v));
//                temp.add(new Vector3f(x,y,z));
//            }
//        }
        //Elliptic cone
//        for(double v = -7 ; v<= 7; v+=Math.PI/60){
//            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
//                float x = 0.5f * (float)((v) * Math.cos(u));
//                float y = 0.5f * (float)((v) * Math.sin(u));
//                float z = 0.5f * (float)((v));
//                temp.add(new Vector3f(x,z,y));
//            }
//        }
        //Eliptic paraboloid
//        for(double v = -7 ; v<= 0; v+=Math.PI/60){
//            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
//                float x = 0.3f * (float)((v) * Math.cos(u));
//                float y = 0.3f * (float)((v) * Math.sin(u));
//                float z = 0.1f * (float)(Math.pow(v,2));
//                temp.add(new Vector3f(x,y,z));
//            }
//        }
        //Hyperboloid paraboloid
//        for(double v = -7 ; v<= 0; v+=Math.PI/60){
//            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
//                float x = 0.1f * (float)((v) * Math.tan(u));
//                float y = 0.1f * (float)((v) * 1/Math.cos(u));
//                float z = 0.1f * (float)(Math.pow(v,2));
//                temp.add(new Vector3f(x,z,y));
//            }
//        }
//        vertices = temp;
//    }

//    public void createCylindric() {
//        ArrayList<Vector3f> temp = new ArrayList<>();
//        for(double v = -0.5; v <= 0.5; v += 0.01){
//            for(double u = -Math.PI; u <= Math.PI; u += Math.PI/60){
//                float x = 0.5f * (float)(Math.cos(u));
//                float z = 0.5f * (float)(Math.sin(u));
//                float y = (float)v;
//                temp.add(new Vector3f(x,y,z));
//            }
//        }
//        vertices = temp;
//    }

//    public void createCylindric() {
//        ArrayList<Vector3f> temp = new ArrayList<>();
//        for(double v = -0.5; v <= -0.3; v += 0.01){
//            for(double u = -Math.PI; u <= Math.PI; u += Math.PI/60){
//                float x = 0.5f * (float)(Math.cos(u));
//                float z = 0.5f * (float)(Math.sin(u));
//                float y = (float)v;
//                temp.add(new Vector3f(x,z,y));
//            }
//        }
//        vertices = temp;
//    }

//     half kepala
    public void createKepala() {
        ArrayList<Vector3f> temp = new ArrayList<>();
        for(double v = 0; v <= 0.25; v += 0.01){
            for(double u = -Math.PI; u <= 0; u += Math.PI/60){
                float x = 0.5f * (float)(Math.cos(u));
                float z = 0.5f * (float)(Math.sin(u));
                float y = (float)v;
                temp.add(new Vector3f(x,z,y));
            }
        }
        vertices= temp;
    }

    // half half kepala
//    public void createKepala() {
//        ArrayList<Vector3f> temp = new ArrayList<>();
//        for(double v = 0; v <= 0.75; v += 0.01){
//            for(double u = -Math.PI; u <= -Math.PI/4; u += Math.PI/60){
//                float x = 0.75f * (float)(Math.cos(u));
//                float z = 0.75f * (float)(Math.sin(u));
//                float y = (float)v;
//                temp.add(new Vector3f(x,z,y));
//            }
//        }
//        vertices = temp;
//    }
}
