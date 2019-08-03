package domain.lifecycle.topcoder

import infrastructure.db.TopCoderDao
import scalikejdbc._
class TopcoderRepository {
  def store = {
    val tcDao = new TopCoderDao
    implicit val session = AutoSession
    tcDao.all
  }
}
