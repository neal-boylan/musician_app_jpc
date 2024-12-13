package ie.setu.musician_jpc.data.api

import ie.setu.musician_jpc.data.model.ClipModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ClipService {
    @GET(ServiceEndPoints.CLIPS_ENDPOINT)
    suspend fun getall(@Path("email") email: String): Response<List<ClipModel>>

    @GET(ServiceEndPoints.CLIPS_ENDPOINT + "/{id}")
    suspend fun get(@Path("email") email: String,
                    @Path("id") id: String): Response<List<ClipModel>>

    @DELETE(ServiceEndPoints.CLIPS_ENDPOINT + "/{id}")
    suspend fun delete(@Path("email") email: String,
                       @Path("id") id: String): ClipWrapper

    @POST(ServiceEndPoints.CLIPS_ENDPOINT)
    suspend fun post(@Path("email") email: String,
                     @Body donation: ClipModel): ClipWrapper

    @PUT(ServiceEndPoints.CLIPS_ENDPOINT + "/{id}")
    suspend fun put(@Path("email") email: String,
                    @Path("id") id: String,
                    @Body donation: ClipModel
    ): ClipWrapper
}