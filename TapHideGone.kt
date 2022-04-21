verticalBlog.setOnTouchListener(object : OnTouchListener {
                private var pointX = 0f
                private var pointY = 0f
                private val tolerance = 50
                override fun onTouch(v: View, event: MotionEvent): Boolean {
                    when (event.action) {
                        MotionEvent.ACTION_MOVE -> {
                            language.visibility = View.GONE
                            return false
                        }
                            //This is important, if you return TRUE the action of swipe will not take place.
                        MotionEvent.ACTION_DOWN -> {
                            pointX = event.x
                            pointY = event.y
                        }
                        MotionEvent.ACTION_UP -> {
                            val sameX = pointX + tolerance > event.x && pointX - tolerance < event.x
                            val sameY = pointY + tolerance > event.y && pointY - tolerance < event.y
                            if (sameX && sameY) {
                                language.visibility = View.VISIBLE
                                //The user "clicked" certain point in the screen or just returned to the same position an raised the finger
                            }
                        }
                    }
                    return false
                }
            })