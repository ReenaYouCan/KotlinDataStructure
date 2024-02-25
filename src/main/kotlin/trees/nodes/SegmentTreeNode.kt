package trees.nodes


class SegmentTreeNode(
    var left: SegmentTreeNode? = null,
    var right: SegmentTreeNode? = null,
    var data: Int = 0,
    var startInterval: Int = 0,
    var endInterval: Int = 0
)
