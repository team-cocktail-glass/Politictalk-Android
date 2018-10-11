package politictalk.dsm;

import com.google.gson.JsonObject;

import java.util.List;

import politictalk.dsm.Model.PoliListModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {
    @POST("account/login")
    Call<Void> post_login(@Body JsonObject jsonObject);

    @POST("account/signup")
    Call<Void> post_signup(@Body JsonObject jsonObject);

    @GET("politician/list")
    Call<List<PoliListModel>> get_politician(@Query("region") String region, @Query("position") String position, @Query("name") String name);

}
