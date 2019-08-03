package domain.model.topcoder

import java.time.ZonedDateTime

import org.joda.time.DateTime
import play.api.libs.json.{JsObject, Json, Writes}
import scalikejdbc._

case class TopcoderProblems(
                             id: Long,
                             topcoderProblemTypeId: Long,
                             name: String,
                             number: Option[String],
                             className: String,
                             methodName: String,
                             round: Option[String],
                             statementHtml: String,
                             createdAt: ZonedDateTime,
                             updatedAt: ZonedDateTime
                           )

object TopcoderProblems extends SQLSyntaxSupport[TopcoderProblems] {
  val tp = TopcoderProblems.syntax("tp")
  implicit val writes: Writes[TopcoderProblems] = {
    new Writes[TopcoderProblems] {
      def writes(tp: TopcoderProblems): JsObject = {
        Json.obj("id" -> tp.id,
          "topcoderProblemTypeId" -> tp.topcoderProblemTypeId,
          "name" -> tp.name,
          "number" -> tp.number,
          "className" -> tp.className,
          "methodName" -> tp.methodName,
          "round" -> tp.round,
          "statementHtml" -> tp.statementHtml,
          "createdAt" -> tp.createdAt,
          "updatedAt" -> tp.updatedAt
        )
      }
    }
  }

  def apply(u: ResultName[TopcoderProblems])(rs: WrappedResultSet): TopcoderProblems =
    TopcoderProblems(rs.long(tp.resultName.id), rs.long(tp.resultName.topcoderProblemTypeId), rs.string(tp.resultName.name),
      rs.stringOpt(tp.resultName.number), rs.string(tp.resultName.className), rs.string(tp.resultName.methodName), rs.stringOpt(tp.resultName.round),
      rs.string(tp.resultName.statementHtml), rs.dateTime(tp.resultName.createdAt), rs.dateTime(tp.resultName.updatedAt))

}