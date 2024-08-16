package com.example.data.repository

import javax.inject.Inject

interface ExampleRepository {
}

class ExampleRepositoryImpl @Inject constructor(
    //ローカルDBを使う場合はこのコメントを外す。
    //private val exampleDao: ExampleDao,
) : ExampleRepository {
}