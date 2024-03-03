package com.example.coroutine_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val coroutine = Coroutine()
        coroutine.main()
    }
}

class Coroutine {
    fun main() {
        // 코루틴 시작
        GlobalScope.launch {
            Log.d("코루틴", "coroutine started!")

            val result = withContext(Dispatchers.Default) {
                simulateAsyncTask()
            }

            Log.d("코루틴", "코루틴 끝, 결과는 $result")
        }

        Log.d("코루틴", "메인 스레드에서 다른 작업 수행")
        Thread.sleep(2000) // 코루틴 끝날 때까지 메인 스레드 대기시키기
    }

    // 비동기 작업 시뮬레이션
    suspend fun simulateAsyncTask(): String {
        delay(1000) // 1초 동안 대기 (실제로는 네트워크 호출 또는 데이터베이스 액세스 등)
        return "비동기 작업 완료"
    }
}