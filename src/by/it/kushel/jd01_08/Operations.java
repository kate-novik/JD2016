package by.it.kushel.jd01_08;

/**
 * Created by Diomn on 21.05.2016.
 */
public class Operations {

    public  VectorVariable addVectorToVector(double[] vector1, double[] vector2){
        double[] resVector=new double[vector1.length];
        VectorVariable res=new VectorVariable();
        if (vector1.length==vector2.length){
            for (int i=0; i<vector1.length; i++){
                for (int j=0; j<vector2.length; j++){
                   resVector[i]= vector1[i]+vector2[j];
                }
            }
        }
res.setValue(resVector);
        return res;
    }
/*    public  double[] subVectorToVector(double[] vector1, double[] vector2){
        double[] resVector=new double[vector1.length];
        if (vector1.length==vector2.length){
            for (int i=0; i<vector1.length; i++){
                for (int j=0; j<vector2.length; j++){
                    resVector[i]= vector1[i]-vector2[j];
                }
            }
        }

        return resVector;
    }
    public  void mulVectorToVector(double[] vector1, double[] vector2){
        System.out.println("Здесь должно быть умножение вектора на вектор");

    }
    public  void delVectorToVector(double[] vector1, double[] vector2){
        System.out.println("Здесь должно быть деление вектора на вектор");

    }*/

    public DoubleVariable addDoubleTo (DoubleVariable var1, DoubleVariable var2){
        DoubleVariable res  = new DoubleVariable();
        double resValue=(double)(var1.getValue())+ (double)(var2.getValue());
        res.setValue(resValue);
        return res;
    }
}
