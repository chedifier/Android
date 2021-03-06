package casetest;

/**
 * 本地修改&云端修改   有冲突
 * 
 * last: ABC				1
 * cloud: 对换BC位置: 		ACB	2
 * local: 修改 对换AB位置： 	BAC	3
 * expect: BAC or ACB
 * 
 * 
 * @author chedifier
 *
 */
public class BookmarkCase3_modify_conflict extends TestCase{

	@Override
	public void prepareCase() {
		caseData.add(new TestBookmarkBuilder("A")
				.dirty(0)
				.local_next("C")				
				.order_time(3L)
				.cloud_next("C")
				.cloud_order_time(2L)
				.build());
		
		caseData.add(new TestBookmarkBuilder("B")
				.dirty(0)
				.local_next("A")
				.order_time(3L)
				.cloud_next(null)
				.cloud_order_time(2L)
				.build());
		
		caseData.add(new TestBookmarkBuilder("C")
				.dirty(0)
				.local_next(null)
				.order_time(1L)
				.cloud_next("B")
				.cloud_order_time(2L)
				.build());
	}

}
