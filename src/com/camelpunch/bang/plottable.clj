(ns com.camelpunch.bang.plottable)

(defprotocol Plottable
  (plot-text [screen x y text])
  (update [screen]))
