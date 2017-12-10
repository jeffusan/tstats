package org.kropek.tstats

import org.scalatest._
import org.scalacheck.Gen
import prop._

class EmojiLoaderSpec extends FlatSpec with Matchers {

  val emojis = EmojiLoader.emojisFromFile("emoji.json")
  val finder = EmojiUtil.findEmojis(emojis)_

  val tweets = Seq(
    (3, "楽しかった😄🎵🎵"),
    (7, "DECK ALERT 📣📣📣📣📣📣📣"),
    (1, "don't rt ty 😬"),
    (3, "Já falsinho 😂↪😂"),
    (4, "ยิ้มตั้งแต่เห็นแจ้งเตือน ยังไม่เห็นรูป💖🌻💖🌻"),
    (3, "🎁 Field-Tested StatTrak™ AK-47 | Redline 🎁"),
    (3, "クリスマスのショー✨🎄✨")
  )

  "emojis" should "be loaded" in {
    emojis.size shouldBe 845
  }

  "emojis" should "be found" in {
    tweets.foreach { tweet =>
      finder(tweet._2) should have size tweet._1
    }

  }

}
