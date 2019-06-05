package org.wikiedufoundation.wikiedudashboard.course_detail.common.provider

import android.util.Log

import org.wikiedufoundation.wikiedudashboard.course_detail.common.data.CourseDetailResponse
import org.wikiedufoundation.wikiedudashboard.helper.PresenterCallback
import org.wikiedufoundation.wikiedudashboard.helper.ProviderUtils
import org.wikiedufoundation.wikiedudashboard.helper.WikiEduDashboardApi

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitCourseDetailProvider : CourseDetailProvider {

    private val wikiEduDashboardApi: WikiEduDashboardApi = ProviderUtils.apiObject

    override fun requestCourseDetail(url: String, presenterCallback: PresenterCallback<*>) {
        val sub_url = "courses/$url/course.json"
        val courseDetailResponseCall = wikiEduDashboardApi.getCourseDetail(sub_url)
        courseDetailResponseCall.enqueue(object : Callback<CourseDetailResponse> {
            override fun onResponse(call: Call<CourseDetailResponse>, response: Response<CourseDetailResponse>) {
                Log.d("Success: ",response.body().toString()+"")
                presenterCallback.onSuccess(response.body())
            }

            override fun onFailure(call: Call<CourseDetailResponse>, t: Throwable) {
                presenterCallback.onFailure()
                t.printStackTrace()
                Log.d("Failure: ", t.message + "")
            }
        })
    }
}
