package infrastructure.db
import domain.model.topcoder.TopcoderProblems
import scalikejdbc._

class TopCoderDao {
  import domain.model.topcoder.TopcoderProblems.tp
  def all(implicit session: DBSession) =
  withSQL {
    QueryDSL.selectFrom(TopcoderProblems as tp)
  }.map(TopcoderProblems(tp.resultName)).list.apply()
}
