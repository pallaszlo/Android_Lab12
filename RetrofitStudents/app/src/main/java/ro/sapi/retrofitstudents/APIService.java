package ro.sapi.retrofitstudents;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIService {

 @GET("students/{id}")
 Call<Student> getStudent(@Path("id") int id);

 @DELETE("students/{id}")
 public Call<Student> deleteStudentWithID(@Path("id") int id);

 //Insert new student
 @FormUrlEncoded
 @POST("students")
 public Call<Student> createStudent(
         //@Field("program_id") Integer program_id,
         @Field("name") String name,
         @Field("email") String email);

}
