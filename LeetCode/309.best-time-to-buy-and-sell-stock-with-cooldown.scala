/*
 * @lc app=leetcode id=309 lang=scala
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */

// @lc code=start
object Solution {
  def maxProfit(prices: Array[Int]): Int = {
    val len = prices.length
    val trades = scala.collection.mutable.Map[Int,List[Int]]()
    for (i <- 0 until len-1; j <- i+1 until len) {
      if (prices(i) < prices(j)) {
        try {trades += i -> (j :: trades(i))}
        catch {case e: NoSuchElementException => trades += i -> List(j)}
      }
    }

    def getProfit(buys: List[Int]): Int = {
      if (buys.isEmpty) return 0
      var profit = 0
      for (buy <- buys) {
        for (sell <- trades(buy)) profit = {
          profit max prices(sell)-prices(buy) + {
            if (sell < len-3) getProfit(buys.filter(_ > sell+1))
            else 0
          }
        }
      }
      profit
    }
    getProfit(trades.keys.toList)
  }
}
// @lc code=end

/*
def maxProfit(prices: Array[Int]): Int = {
  def trade(list: List[Int],state: Option[String],profit: Int): Int = state match {
    case Some("buying") => {
      if (list.tail.isEmpty) profit-list.head
      else 
          trade(list.tail,Some("holding"),profit-list.head) max
          trade(list.tail,Some("selling"),profit-list.head)
    }
    case Some("holding") => {
      if (list.tail.isEmpty) profit+list.head
      else 
          trade(list.tail,Some("holding"),profit) max
          trade(list.tail,Some("selling"),profit)
    }
    case Some("selling") => {
      if (list.tail.isEmpty) profit+list.head
      else
          trade(list.tail,None,profit+list.head)
    }
    case None => {
      if (list.tail.isEmpty) profit
      else 
          trade(list.tail,Some("buying"),profit) max
          trade(list.tail,None,profit)
    }
    case _ => throw new Exception("Invalid trading state")
  }
trade(prices.toList,Some("buying"),0) max trade(prices.toList,None,0)
}
*/
