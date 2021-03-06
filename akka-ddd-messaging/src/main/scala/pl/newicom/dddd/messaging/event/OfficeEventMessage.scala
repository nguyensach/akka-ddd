package pl.newicom.dddd.messaging.event

import org.joda.time.DateTime
import pl.newicom.dddd.aggregate.DomainEvent
import pl.newicom.dddd.messaging.MetaData
import pl.newicom.dddd.office.CaseRef
import pl.newicom.dddd.utils.UUIDSupport._


object OfficeEventMessage {
  def apply(em: EventMessage, caseRef: CaseRef): OfficeEventMessage =
    OfficeEventMessage(caseRef, em.event, em.id, em.timestamp, em.metadata)
}

case class OfficeEventMessage(
                               caseRef: CaseRef,
                               event: DomainEvent,
                               id: String = uuid,
                               timestamp: DateTime = new DateTime,
                               metadata: Option[MetaData] = None)
  extends EventMessage {

  override type MessageImpl = OfficeEventMessage

  override def copyWithMetaData(m: Option[MetaData]): OfficeEventMessage =
    copy(metadata = m)

  override def toString: String = {
    s"OfficeEventMessage(event = $event, id = $id, timestamp = $timestamp, metaData = $metadata)"
  }

}