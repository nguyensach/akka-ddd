package pl.newicom.dddd.aggregate

import pl.newicom.dddd.aggregate.AggregateRootSupport.{Reject, RejectConditionally}
import pl.newicom.dddd.aggregate.error.DomainException

trait BehaviorSupport {
  def error(msg: String): Reject  = reject(msg)
  def reject(msg: String): Reject = Reject(new DomainException(msg))

  def reject(reason: DomainException): Reject = Reject(reason)

  def rejectIf(condition: Boolean, reason: String): RejectConditionally    = new RejectConditionally(condition, reject(reason))
  def rejectIf(condition: Boolean, reject: => Reject): RejectConditionally = new RejectConditionally(condition, reject)
}
