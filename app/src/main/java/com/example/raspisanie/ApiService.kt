package com.example.raspisanie

import com.example.raspisanie.Model.Day
import com.example.raspisanie.Model.Groups
import com.example.raspisanie.Model.LessonOrder
import com.example.raspisanie.Model.LessonTypes
import com.example.raspisanie.Model.Lessons
import com.example.raspisanie.Model.Offices
import com.example.raspisanie.Model.Semesters
import com.example.raspisanie.Model.Subjects
import com.example.raspisanie.Model.Teachers
import com.example.raspisanie.Model.TypeOffices
import com.example.raspisanie.Model.Weeks
import retrofit2.http.GET

interface ApiService {
    @GET("day/get/")
    suspend fun getDay():List<Day>

    @GET("group/get/")
    suspend fun getGroups():List<Groups>

    @GET("lessonOrder/get/")
    suspend fun getLessonOrder():List<LessonOrder>

    @GET("lessons/get/")
    suspend fun getLessons():List<Lessons>

    @GET("lessonType/get/")
    suspend fun getLessonTypes():List<LessonTypes>

    @GET("office/get/")
    suspend fun getOffices():List<Offices>

    @GET("semester/get/")
    suspend fun getSemesters():List<Semesters>

    @GET("subject/get/")
    suspend fun getSubjects():List<Subjects>

    @GET("teacher/get/")
    suspend fun getTeachers():List<Teachers>

    @GET("typeOffice/get/")
    suspend fun getTypeOffices():List<TypeOffices>

    @GET("week/get/")
    suspend fun getWeeks():List<Weeks>
}