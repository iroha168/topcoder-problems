package application.service.topcoder

import domain.model.topcoder.TopcoderProblems
import domain.lifecycle.topcoder.TopcoderRepository

class TopcoderService {
  def listProblems(): Seq[TopcoderProblems] = {
    val tcRepository = new TopcoderRepository
    tcRepository.store
  }
}
