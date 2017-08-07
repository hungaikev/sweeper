package com.sample

import java.util.concurrent.TimeUnit

import akka.actor.ActorSystem
import com.typesafe.akka.extension.quartz.QuartzSchedulerExtension
import com.typesafe.config.ConfigFactory

import scala.concurrent.Await
import scala.concurrent.duration.Duration

import scala.collection.JavaConversions._

/**
  * Created by hungai on 8/7/17.
  */
object Boot {

  def main(args: Array[String]): Unit = {

    val system = ActorSystem("DemoApp")

    getScheduleNames().foreach(sendRecuringMessages(_))
    Await.ready(system.whenTerminated, Duration(1, TimeUnit.MINUTES))


    def sendRecuringMessages(mySchedule: String) = {
      val sweeper = system.actorOf(Sweeper.props)
      QuartzSchedulerExtension(system).schedule(mySchedule,sweeper,Message)

    }

    def getScheduleNames() = {
      val conf = ConfigFactory.load("quartz.conf")
      val schedules = conf.getConfig("akka.quartz.schedules").entrySet()
      schedules.map(schedule => schedule.getKey.split("\\.")(0)).toList.distinct
    }

  }

}
