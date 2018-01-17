package chkksjpt.colomind.chkksjpt.Network;

import java.io.File;
import java.util.List;
import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2017/9/29.
 * Retrofit2 需要service作为媒介发起请求
 */

public interface NetworkService {

    /*@Multipart
    @POST("{postUrl}")
    Call<String> uploadPhotos(
            @Path("postUrl") String postUrl,
            @Part List<MultipartBody.Part> partList);*/

    @Multipart
    @POST("{postUrl}")
    Observable<RequestBody> uploadPhotos(
            @Path("postUrl") String postUrl,
            @Part List<MultipartBody.Part> partList);

    @GET("{url}")
    Call<File> downloadFile(@Path("url") String downloadUrl);

    @Multipart
    @POST("{methodName}")
    Observable<ResponseBody> uploadFiles(
            @Path("methodName") String methodName,
            @Part List<MultipartBody.Part> partList);

}
