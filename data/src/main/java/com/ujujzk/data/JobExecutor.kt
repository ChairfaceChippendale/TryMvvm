package com.ujujzk.data

import com.ujujzk.domain.executor.ThreadExecutor
import java.util.concurrent.LinkedBlockingDeque
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JobExecutor  : ThreadExecutor {

    val threadPoolExecutor: ThreadPoolExecutor = ThreadPoolExecutor(
            3,
            35,
            10,
            TimeUnit.SECONDS,
            LinkedBlockingDeque<Runnable>(),
            JobThreadFactory())

    override fun execute(command: Runnable?) = threadPoolExecutor.execute(command)


    class JobThreadFactory : ThreadFactory {
        private var counter = 0
        override fun newThread(r: Runnable?): Thread = Thread(r, "android_${counter++}")
    }
}