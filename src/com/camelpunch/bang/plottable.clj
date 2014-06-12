(ns com.camelpunch.bang.plottable)

(defprotocol Plottable
  (update [screen items]))
